package bastion.defiantce.module.player;

import org.lwjgl.input.Keyboard;

import bastion.defiantce.module.Category;
import bastion.defiantce.module.Module;
import bastion.defiantce.utils.Invoker;

public class FastLadder extends Module{
	
	private int ticks = 0;

	public FastLadder() {
		super("FastLadder", 0, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			ticks++;
			if(Invoker.isOnLadder() && Keyboard.isKeyDown(Invoker.getForwardCode())) {
				Invoker.setMotionY(0.5);
			}else if(Invoker.isOnLadder() && !Keyboard.isKeyDown(Invoker.getForwardCode())) {
				Invoker.setMotionY(-0.5);
			}
		}
	}

}
