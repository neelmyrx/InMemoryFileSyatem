# InMemoryFileSyatem


Root directory  - Starting point. It acts as the base of the directory structure.
Each directory(including root) can contains two items. Those items can be either file or sub directories.
Can be implemented using two Java ConcurrentMap and a Container.
The Container contains two ConcurrentHashMaps.

 1. One map for directories. Key here is Directory name and value is Directory It self
    ConcurrentHashMap<String, Directory> directories = new ConcurrentHashMap<String, Directory>();
   
 2. The Second Map for files. Key Here is File name and Value is the File Content
    ConcurrentHashMap<String, String> files = new ConcurrentHashMap<String, String>();
	
  
 We can use other Datastructure too but ConcurrentHashMap is thead safe and better in performane then synchronized map and hashTable
	
	
The advantage of this scheme of maintaining the directory structure is that it is expandable.
Extracting only directories or files list on any path is easy in this case, since we maintain separate entires for direcor and filesfiles. 
