package bastion.defiantce.module.player;

import bastion.defiantce.module.Category;
import bastion.defiantce.module.Module;
import bastion.defiantce.utils.timers.Timer2;

public class AntiAFK extends Module{

	public AntiAFK() {
		super("AntiAFK", 0, Category.PLAYER);
	}
	
	int tickCount = 1;
	int afkCount = 1;
	Timer2 timer = new Timer2();
	Timer2 timer2 = new Timer2();
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindForward.pressed = true;
			if(timer.check(500)) {
				mc.thePlayer.rotationYaw = mc.thePlayer.prevRotationYaw -= 90;
				timer.reset();
			}
		}
	}
	
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindForward.pressed = false;
	}

}