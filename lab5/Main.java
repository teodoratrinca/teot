import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            app.testLoadView();
        } catch (ClassNotFoundException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    private void testCreateSave()throws IOException{
        Catalog catalog =
                new Catalog("Java Resources", "d:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
        try {
            CatalogUtil.save(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testLoadView() throws IOException, ClassNotFoundException, URISyntaxException {
        Catalog catalog = CatalogUtil.load( "d:/java/catalog.ser");
        assert catalog != null;
        Document document1 = catalog.findById("java1");
        CatalogUtil.view(document1);

    }
}
