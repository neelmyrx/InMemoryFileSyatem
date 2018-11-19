
/**
 * 
 * InMemoryFileSystem class has a reference to the base directory 
 * It process a given input String and find the directory and process it.
 * It travel the tree to the exact directory and perform the operation 
 * 
 * */
public class InMemoryFileSystem {

	Directory baseDirectory;// reference to the base Directory

	public InMemoryFileSystem() {
		baseDirectory = new Directory();
	}
	
	/**
	 * 
	 * @param path The exact path to the directory
	 * @param sort  if true it sorts the files according to their name a
	 * @return
	 */
	public List<String> listAllTheFiles(String path, boolean sort) {
		Directory t = baseDirectory;
		List<String> files = new ArrayList<>();
		if (!path.equals("/")) {
			String[] d = path.split("/");
			for (int i = 1; i < d.length - 1; i++) {
				t = t.directories.get(d[i]);
			}
			if (t.files.containsKey(d[d.length - 1])) {
				files.add(d[d.length - 1]);
				return files;
			} else {
				t = t.directories.get(d[d.length - 1]);
			}
		}
		files.addAll(new ArrayList<>(t.directories.keySet()));
		files.addAll(new ArrayList<>(t.directories.keySet()));
		if (sort) {
			Collections.sort(files);
		}
		return files;
	}
	/**
	 * This method create file or directory
	 * @param path The exact path to the directory
	 * @return
	 */
	public void create(String path) {
		Directory t = baseDirectory;
		String[] d = path.split("/");
		for (int i = 1; i < d.length; i++) {
			if (!t.directories.containsKey(d[i]))
				t.directories.put(d[i], new Directory());
			t = t.directories.get(d[i]);
		}
	}
	/**
	 * This method update a file by appending the content
	 * @param path The exact path to the directory
	 * @return
	 */
	public void addContentToFile(String filePath, String content) {
		Directory t = baseDirectory;
		String[] d = filePath.split("/");
		for (int i = 1; i < d.length - 1; i++) {
			t = t.directories.get(d[i]);
		}
		t.files.put(d[d.length - 1], t.files.getOrDefault(d[d.length - 1], "") + content);
	}
/**
	 * This method read a file 
	 * @param path The exact path to the directory
	 * @return
	 */
	public String readFile(String filePath) {
		Directory t = baseDirectory;
		String[] d = filePath.split("/");
		for (int i = 1; i < d.length - 1; i++) {
			t = t.directories.get(d[i]);
		}
		return t.files.get(d[d.length - 1]);
	}
}
