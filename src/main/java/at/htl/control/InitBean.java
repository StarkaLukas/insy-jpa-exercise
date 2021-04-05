package at.htl.control;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

@RequestScoped
public class InitBean {

    private final EntityManager entityManager;

    private static final String fileName = "script.txt";

    public InitBean(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    void startup(@Observes StartupEvent event) {
        insertTestData();
    }

    private void insertTestData() {
        URL url = Thread.currentThread().getContextClassLoader().getResource(fileName);
        assert url != null;

        try (Stream<String> stream = Files.lines(Paths.get(url.getPath()), StandardCharsets.UTF_8)) {
            stream
                    .forEach(this::insertSql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertSql(String s) {
        Query query = entityManager.createNativeQuery(s);
        query.executeUpdate();
    }
}
