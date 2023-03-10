package de.Ng.Wuppy.Render;

import de.Ng.Wuppy.Wuppy;
import de.Ng.Wuppy.Util.Timer;
import de.Ng.Wuppy.Util.GL.GLUtils;

public class ParticleRenderer {
	
	private int width, height;
	
	private final ParticleEngine particleEngine = new ParticleEngine();
	
	private final Timer timer = new Timer();
	
	public ParticleRenderer(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void updateParticles() {
		particleEngine.updateParticles();
	}
	
	public void renderParticles() {
		GLUtils.glColor(0x6F000000);
		GLUtils.drawRect(0, 0, width, height);
		
		particleEngine.render();
		
		if(timer.hasReach(15)) {
			particleEngine.spawnParticles(Wuppy.RANDOM.nextInt(width + 1), Wuppy.RANDOM.nextInt(height + 1), width, height, 0, 5F);
			timer.reset();
		}
	}
	
	public void updateSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
}