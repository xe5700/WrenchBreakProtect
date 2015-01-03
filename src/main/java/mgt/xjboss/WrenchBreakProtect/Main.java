package mgt.xjboss.WrenchBreakProtect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	String Wrenches[]=null;
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new Event(this), this);;
		LoadWrenches(); 
		System.out.println("[WrenchBreakProtect]Powered by xjboss website:xjboss.net");
	}
	public void LoadWrenches(){
		InputStream WrenchesR=this.getClass().getResourceAsStream("/Wrenches.txt");
		BufferedReader WrenchesF=new BufferedReader(new InputStreamReader(WrenchesR,Charset.forName("utf-8")));
		Object[] ArrayWrenchesF=WrenchesF.lines().toArray();
		int Count=(int)(ArrayWrenchesF.length);
		//System.out.println(Count);
		Wrenches=new String[Count];
			for(int i=0;i<Count;i++){
				Wrenches[i]=ArrayWrenchesF[i].toString();
			}
		try {
			WrenchesF.close();
			WrenchesR.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean checkWrench(String itemname){
		String IN=itemname.split(":")[0];
		for(int i=0;i<Wrenches.length;i++){
			if((itemname.equals(Wrenches[i]))|(IN.equals(Wrenches[i])))return true;
		}
		return false;
	}
}
