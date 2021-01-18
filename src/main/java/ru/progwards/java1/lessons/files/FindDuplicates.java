package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.*;

public class FindDuplicates {
    public List<List<String>> findDuplicates(String startPath) {

        Path pp = Paths.get(startPath);

        List<Path> full = walker(pp);
        Set<List<String>> res = new HashSet<>();


        for (Path x : full) {
            Path xP = x.getFileName();//крайний правый элемент пути
            Set<String> temp = new HashSet<>();

            Iterator<Path> iterator = full.iterator();
            while (iterator.hasNext()) {


                Path y = iterator.next();
                if (x.equals(y)) {

                    continue;
                }

                Path yP = y.getFileName();//крайний правый элемент пути

                if (xP.equals(yP)) {
                    try {
                        if (x.equals(y)) {

                            continue;
                        }
                        if (Files.size(x) == Files.size(y)
                                && Files.getLastModifiedTime(x).equals(Files.getLastModifiedTime(y))
                                && Files.readString(x).equals(Files.readString(y))) {
                            //  System.out.println("полное соотвествие  " + x + " == " + y);
                            temp.add(x.toAbsolutePath().toString());
                            //добавляем абсолютные пути и приводим к строке
                            temp.add(y.toAbsolutePath().toString());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!temp.isEmpty()) res.add(new ArrayList<>(temp));

        }

        List ress = new ArrayList(res);
        return ress;
    }
    public static List<Path> walker(Path start) {
        List<Path> paths = new ArrayList<>();
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**");
        //интерфейс PathMatcher
        try {
            Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
                //обход дерева каталогов walkFileTree
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    if (pathMatcher.matches(start.relativize(path)))
                      //  проверям элемент и вычесляем относительный путь
                        paths.add(path);


                    return FileVisitResult.CONTINUE;//Продолжить процесс посещения
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }


            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paths;
    }
    public static void main(String[] args) {
        FindDuplicates test = new FindDuplicates();
        Path p1 = Paths.get("src/start/file2.txt");
        Path p2 = Paths.get("src/file2.txt");

        try {
            Files.setLastModifiedTime(p1, FileTime.from(Instant.EPOCH));
            Files.setLastModifiedTime(p2, FileTime.from(Instant.EPOCH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

        System.out.println(test.findDuplicates("src"));
    }
}