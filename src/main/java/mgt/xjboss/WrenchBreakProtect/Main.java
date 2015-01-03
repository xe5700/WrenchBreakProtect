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
		
		int Count=0;
		//System.out.println(Count);
		String Wrenches2="";
		try {
			Wrenches2 = WrenchesF.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		//Wrenches=new String[Count];
		try {
			while(true){
				String WRF = WrenchesF.readLine();
				Wrenches2=Wrenches2+(char)(233)+WRF;
				if(WRF==null)break;
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Wrenches=Wrenches2.split(new String(((char)(233))+""));
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
