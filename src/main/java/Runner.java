import db.DBFolder;
import db.DBHelper;
import models.File;
import models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Folder folder1 = new Folder("Documents");
        Folder folder2 = new Folder("Images");
        Folder folder3 = new Folder("Programs");
        Folder folder4 = new Folder("Untitled");

        File file1 = new File("my_cv", "txt", 23, folder1);
        File file2 = new File("shopping_list", "txt", 15, folder1);
        File file3 = new File("funny_pic", "jpg", 54, folder2);
        File file4 = new File("serious_pic", "png", 19, folder2);
        File file5 = new File("sad_pic", "png", 3, folder2);
        File file6 = new File("hello_world", "rb", 1, folder3);

        DBHelper.save(folder1);
        DBHelper.save(folder2);
        DBHelper.save(folder3);
        DBHelper.save(folder4);

        DBHelper.save(file1);
        DBHelper.save(file2);
        DBHelper.save(file3);
        DBHelper.save(file4);
        DBHelper.save(file5);
        DBHelper.save(file6);

        File foundFile = DBHelper.findById(File.class, 2);
        foundFile.setExtension("doc");
        DBHelper.update(foundFile);

        Folder foundFolder = DBHelper.findById(Folder.class, 2);
        foundFolder.setTitle("Pictures");
        DBHelper.update(foundFolder);

        DBHelper.delete(foundFile);
        DBHelper.delete(folder4);

        List<File> foundFiles = DBFolder.getFilesInFolder(foundFolder);

    }

}
