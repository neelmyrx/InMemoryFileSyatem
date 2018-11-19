# InMemoryFileSystem


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






Performance Analysis

Assumptions
1. n refers to the depth of the file name in the current input.
2. m refers to the number of entries(files+subdirectories) in the last level directory(in the current input). 


The time complexity of listing all the files in a directory is O(n+k). 
The time complexity of listing all the files in a directory in  sorted oreder O(n+mlog(m)).  

The time complexity of creating  a directory O(n). 
The time complexity of both creating a new file or reading content from a file  is O(n).

To delete a directory given an input to directory path. We need to simply reach to the destined directory level which takes O(n) time 
and remove the corresponding directory entry from the corresponding directories map which takes constant time O(1). So total time complexity is O(n).

