/*
 * Requirement:
 * 1) Given a folder location, get all the file that ends with .html
 * 2) load html file, change a email name (any thing that ends with hello@fb.com) to different name(hello1@fb.com).
 * 3) challenge is, since it is html, ex input would be <span>hello@fb.com,<b>
 * 4) So splitting is challenge. Do it based on RegEx.
 *
 * Option1: If file is not read by anyone actively
 * 1) Use FileChannel and open file READ_WRITE mode and set channel to LOCK, so that no one can access it.
 * 2) Read a block, find a string. Update the block,write back
 * Option2: If file is read by some process/threads
 * 1) Take a copy, process it, write to a new file, delete old file, rename new file.
 *
 */
public class FaceBookTelephonic1 {
  /*
  	public void renameMailNames(final String directory) {
  		  try {
  		      // Create a pointer to the directory location
  		      File dir = new File(directory); // File should be in resources or readable path
  		      List<String> fileNames = dir.listFiles(); // Need to check on right API
  		      for(String fileName : fileNames) {
  		        if(fileName.endswith(".html") {
  		          renameMailNameInHtmlFile(fileName);
  		        }
  		      }
  		    } catch(IOExcetion io) {
  		    // Handle Directoy Not Found Exception
  		    }
  		}



  		private void renameMailNameInHtmlFile(final String fileName) {
  		    String fileNameToCopy = fileName+"Copy";
  		  try{
  		    FileInputStreamReader reader = new FileInputStreamReader(fileName);
  		    FileOutputStreamReader writer = new FileOutputStreamReader(fileNameToCopy);
  		    // whether file has a line of data
  		    while(reader.hasNext()) {
  		      String line = reader.next();
  		      String updatedLine = renameMailName(line);
  		      writer.write(updatedLine);
  		    }
  		    reader.close();
  		    writer.close();
  		    renameFile(fileName, fileNameToCopy);
  		  } catch(IOException e) {
  		    // Handle File Closing Exceptions
  		  }
  		}

  		private void renameFile(final String source, final String destination) {
  		  try {
  		    File fileToRename = new File(destination);
  		    fileToRename.rename();
  		    File fileToDelete = new File(source);
  		    fileToDelete.delete();
  		  } catch(IOException e) {
  		    // Handle Exception
  		  }

  		}
  		//Ex: <span>zuck@fb.com, sheryl@fb.com are email addresses from people @facebook</span>
  		// RegEx split by ">, "
  		//0 = <span
  		//1 =zuck@fb.com
  		//2=sheryl@fb.com
  		private static final String REGEX = "[A-Za-z]+"; // This needs to be updated with right split special character regex.
  		private static final String nameToBeUpdated = "REMOVED";
  		private String renameMailName(final String input) {
  		  StringBuilder inputBuilder = new StringBuilder(input);
  		  StringBuilder outputBuilder = new StringBuilder();
  		  String[] splitStrings = inputBuilder.split(REGEX);
  		  for(String splitString : splitStrings) {
  		    if(splitString.endswith("@fb.com")) {
  		      //zuck@fb.com... [0]zuck. [1]fb.com
  		      String[] nameAndDomain = splitString.split("@");
  		      outputBuilder.append(nameToBeUpdated).append("@").append(nameAndDomain[1]);
  		    } else {
  		      outputBuilder.append(splitString);
  		    }
  		  }
  		  return outputBuilder.toString();
  		}

  **/
}
