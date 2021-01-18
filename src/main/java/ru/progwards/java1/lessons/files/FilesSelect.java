package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FilesSelect {

    private static String inFolder;
    private static String outFolder;
    private static List<String> keys;

    public void selectFiles(String inFolder, String outFolder, List<String> keys) {
        this.inFolder = inFolder;
        this.outFolder = outFolder;
        this.keys = keys;


        Path in = Paths.get(inFolder);
        walker(in);
    }


    public static void walker(Path start) {

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");
        try {
            Files.walkFileTree(start, new SimpleFileVisitor<Path>() {


                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    if (pathMatcher.matches(start.relativize(path)))
                        check(path);
                    return FileVisitResult.CONTINUE;

                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }


            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void check(Path chek) {

        try {
            String ch = Files.readString(chek);//прочитать в одну строку
            Scanner sc = new Scanner(ch);

            while (sc.hasNext()) {
                String tmp = sc.next();
                Iterator<String> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    if (key.contains(tmp)) {
                        //   System.out.println("key  :" + key);
                        maker(key, chek);
                    }
                }

            }

            sc.close();//закрывает открытый сканер

        } catch (IOException e) {
            System.out.println(chek + "     - error");

        } finally {

        }

    }


    public static void maker(String wrd, Path mak) {
        //   System.out.println("wrd:" + wrd + "     mak:" + mak);
        Path out = Paths.get(outFolder).resolve(wrd);//добавляем элемент пути
        try {
            if (Files.exists(out) == false) {
                //   System.out.println("false /createDirectory/        out=" + out);
                System.out.println(Files.createDirectory(out));//создаем коталог
                Files.copy(mak, out.resolve(mak.getFileName()));//копируем и добавляем элемент в крайний правый
            } else
                Files.copy(mak, out.resolve(mak.getFileName()));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}