import java.util.concurrent.ConcurrentHashMap;


/**
 * 
 * Directory class is the Data structure Will hold the details of its sub-directory and files.
 * It Has two ConcurrentHashMap to manage the directories and files
 * It is also made all the update operations thread safe.
 * 
 * */

class Directory {
	
	public ConcurrentHashMap<String, Directory> directories = new ConcurrentHashMap<String, Directory>();
	public ConcurrentHashMap<String, String> files = new ConcurrentHashMap<String, String>();
	
	public ConcurrentHashMap<String, Directory> getDirectories() {
		return directories;
	}
	public void setDirectories(ConcurrentHashMap<String, Directory> directories) {
		this.directories = directories;
	}
	public ConcurrentHashMap<String, String> getFiles() {
		return files;
	}
	public void setFiles(ConcurrentHashMap<String, String> files) {
		this.files = files;
	}
	
	
}
