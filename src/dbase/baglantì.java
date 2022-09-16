package dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class baglantı {

	static long startTime = System.nanoTime();
	public static void main(String[] args) {
		try {
			Connection myConn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "1234" );
			Statement myStat = (Statement)myConn.createStatement();
			ResultSet myRs = (ResultSet)myStat.executeQuery("select * from otomobil_fiyatlari");
			
			String ekleme = "INSERT INTO otomobil_fiyatlari (id,marka,model,donanim,motor,yakit,vites,fiyat,websitesi) VALUES ('300','ZEO','A3 Sedan','1.0 TFSI 116 hp Sport Line S tronic PI','1600','Benzin','Otomatik','987999','https://www.zoe.com.tr')";
			Statement mystat = myConn.createStatement();
			mystat.executeUpdate(ekleme);
			
			while(myRs.next()) {
				System.out.println(myRs.getString("id")+ " | " + myRs.getString("marka")+ " | " + myRs.getString("model")+ " | " + myRs.getString("donanim")+ " | " + myRs.getString("motor")+ " | " + myRs.getString("yakit")+ " | " + myRs.getString("vites")+ " | " + myRs.getString("fiyat")+ " | " + myRs.getString("websitesi"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print("\nTOTAL SURE: ");
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
}

