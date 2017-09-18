package org.util.logviewer.source.file.ssh;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.util.logviewer.source.LogSource;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class SshFileLogSource implements LogSource {

	@Override
	public String readLog() {
		// TODO Auto-generated method stub
		return null;
	}
	static int checkAck(InputStream in) throws IOException{
	    int b=in.read();
	    // b may be 0 for success,
	    //          1 for error,
	    //          2 for fatal error,
	    //          -1
	    if(b==0) return b;
	    if(b==-1) return b;

	    if(b==1 || b==2){
	      StringBuffer sb=new StringBuffer();
	      int c;
	      do {
		c=in.read();
		sb.append((char)c);
	      }
	      while(c!='\n');
	      if(b==1){ // error
		System.out.print(sb.toString());
	      }
	      if(b==2){ // fatal error
		System.out.print(sb.toString());
	      }
	    }
	    return b;
	  }
	public static void main(String[] a) throws JSchException, IOException {
		JSch jsch = new JSch();
		Session session = jsch.getSession("ibeuser", "DOHDRDEP01", 22);
		//jsch.setKnownHosts("known_hosts.txt");
		java.util.Properties config = new java.util.Properties(); 
	    config.put("StrictHostKeyChecking", "no");
	    session.setConfig(config);
		 // UserInfo ui=new MyUserInfo();
		 //session.setUserInfo(ui);
		session.setPassword("ibeuser123");
		
		  session.connect();
		  String command="scp -f "+"/deployments/mbe/configs/MBE01/logback.xml";
	      Channel channel=session.openChannel("exec");
	      ((ChannelExec)channel).setCommand(command);
	      OutputStream out=channel.getOutputStream();
	      InputStream in=channel.getInputStream();
	      String prefix=null;
	      String lfile="D:\\Users\\61008\\Desktop\\aa.txt";
	      if(new File(lfile).isDirectory()){
	        prefix=lfile+File.separator;
	      }
	      channel.connect();

	      byte[] buf=new byte[1024];

	      // send '\0'
	      buf[0]=0; out.write(buf, 0, 1); out.flush();

	      while(true){
		int c=checkAck(in);
	        if(c!='C'){
		  break;
		}
	        in.read(buf, 0, 5);

	        long filesize=0L;
	        while(true){
	          if(in.read(buf, 0, 1)<0){
	            // error
	            break; 
	          }
	          if(buf[0]==' ')break;
	          filesize=filesize*10L+(long)(buf[0]-'0');
	        }

	        String file=null;
	        for(int i=0;;i++){
	          in.read(buf, i, 1);
	          if(buf[i]==(byte)0x0a){
	            file=new String(buf, 0, i);
	            break;
	  	  }
	        }

		//System.out.println("filesize="+filesize+", file="+file);

	        // send '\0'
	        buf[0]=0; out.write(buf, 0, 1); out.flush();

	        // read a content of lfile
	        FileOutputStream  fos=new FileOutputStream(prefix==null ? lfile : prefix+file);
	        int foo;
	        while(true){
	          if(buf.length<filesize) foo=buf.length;
		  else foo=(int)filesize;
	          foo=in.read(buf, 0, foo);
	          if(foo<0){
	            // error 
	            break;
	          }
	          fos.write(buf, 0, foo);
	          filesize-=foo;
	          if(filesize==0L) break;
	        }
	        fos.close();
	        fos=null;

		if(checkAck(in)!=0){
		  System.exit(0);
		}

	        // send '\0'
	        buf[0]=0; out.write(buf, 0, 1); out.flush();
	      }

	      session.disconnect();

	}
	@Override
	public boolean hasMoreData() {
		// TODO Auto-generated method stub
		return false;
	}

}
