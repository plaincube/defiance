package bastion.defiantce.command.commands;

import org.lwjgl.input.Keyboard;

import bastion.defiantce.Defiant;
import bastion.defiantce.command.Command;
import bastion.defiantce.module.Module;
import bastion.defiantce.module.ModuleManager;

public class Bind extends Command {

	public Bind() {
		super("Bind", "Binds a module to a key on your keyboard.", "dce--bind <module> <key> | bind clear", "b");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 2) {
			String moduleName = args[0];
			String keyName = args[1];
			
			boolean foundModule = false;
			
			for(Module module : Defiant.instance.moduleManager.getModules()) {
				if(module.name.equalsIgnoreCase(moduleName)) {
					module.setKey(Keyboard.getKeyIndex(keyName.toUpperCase()));
					
					Defiant.instance.moduleManager.addChatMessage(String.format("Bound %s to %s" + "!", module.name, Keyboard.getKeyName(module.getKey())));
					foundModule = true;
					break;
				}
			}
			
			if(!foundModule) {
				Defiant.instance.moduleManager.addChatMessage("Module not found!");
			}
			
		}
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("clear")) {
				for(Module module : Defiant.instance.moduleManager.getModules()) {
					module.setKey(Keyboard.KEY_NONE);
				}
			}
			Defiant.instance.moduleManager.addChatMessage("All keybinds cleared!");
		}
		
	}

	
	
}
