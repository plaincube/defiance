package bastion.defiantce.module.movement;

import org.lwjgl.input.Keyboard;

import bastion.defiantce.module.Category;
import bastion.defiantce.module.Module;

public class SprintLock extends Module {

	public SprintLock() {
		super("SprintLock", Keyboard.KEY_F, Category.MOVEMENT);
	}
	
	public void onEnable() {
		if(this.isToggled()) {
			mc.thePlayer.setSprinting(true);
			super.onEnable();
		}
	}
	
	public void onDisbale() {
		mc.thePlayer.setSprinting(false);
		super.onDisable();
	}

}
