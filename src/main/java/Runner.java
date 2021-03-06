import db.DBFolder;
import db.DBHelper;
import db.DBOwner;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner1 = new Owner("Robbie", "robbieisthebest");
        Owner owner2 = new Owner("Ellie", "ellielikesjelly");

        Folder folder1 = new Folder("Documents", owner1);
        Folder folder2 = new Folder("Images", owner2);
        Folder folder3 = new Folder("Programs", owner1);
        Folder folder4 = new Folder("Untitled", owner1);

        File file1 = new File("my_cv", "txt", 23, folder1);
        File file2 = new File("shopping_list", "txt", 15, folder1);
        File file3 = new File("funny_pic", "jpg", 54, folder2);
        File file4 = new File("serious_pic", "png", 19, folder2);
        File file5 = new File("sad_pic", "png", 3, folder2);
        File file6 = new File("hello_world", "rb", 1, folder3);

        DBHelper.save(owner1);
        DBHelper.save(owner2);

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

        Owner foundOwner = DBHelper.findById(Owner.class, 1);

        List<File> foundFiles = DBFolder.getFilesInFolder(foundFolder);

        List<Folder> foundFolders = DBOwner.getFoldersOfOwner(foundOwner);

    }

}
