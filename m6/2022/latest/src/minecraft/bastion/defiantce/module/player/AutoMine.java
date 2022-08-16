package bastion.defiantce.module.player;

import bastion.defiantce.module.Category;
import bastion.defiantce.module.Module;
import bastion.defiantce.utils.Invoker;
import net.minecraft.util.MovingObjectPosition;

public class AutoMine extends Module{

	public AutoMine() {
		super("AutoMine", 0, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			MovingObjectPosition hover = Invoker.getObjectMouseOver();
			
			if(hover.typeOfHit != null) {
				if(hover.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
					Invoker.setKeyBindAttackPressed(true);
				}
			}else {
				Invoker.setKeyBindAttackPressed(false);
			}
		}
	}

}