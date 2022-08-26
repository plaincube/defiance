package bastion.defiantce.command.commands;

import bastion.defiantce.Defiant;
import bastion.defiantce.command.Command;
import bastion.defiantce.module.Module;

public class Toggle extends Command {

	public Toggle() {
		super("Toggle", "Toggles a module.", "dce--toggle <module>", "t");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length > 0) {
			String moduleName = args[0];
			
			boolean foundModule = false;
			
			for(Module module : Defiant.instance.moduleManager.getModules()) {
				if(module.name.equalsIgnoreCase(moduleName)) {
					module.toggle();
					
					Defiant.instance.moduleManager.addChatMessage((module.isToggled() ? "Enabled" : "Disabled") + " " + module.name);
					
					foundModule = true;
					break;
				}
			}
			if(!foundModule) {
				Defiant.instance.moduleManager.addChatMessage("Module not found!");
			}
		}
	}

}
