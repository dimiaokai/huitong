package cn.tarena.ht.tool;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;

public class MD5Hash {
	
	public static void main(String[] args) {
		
		/**
		 * source: 明文
		 * salt:   盐
		 * hashIterations  哈希的次数
		 */
		
		Md5Hash md5Hash = new Md5Hash("root", "root", 3);
		System.out.println(md5Hash.toString());
	}
	
	public static String getMd5HashPasswod(String password,String userName){
		
		return new Md5Hash(password,userName,3).toString();
	}
}
