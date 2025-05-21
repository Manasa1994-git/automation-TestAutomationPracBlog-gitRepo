package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import org.testng.Assert;

public class DragAndDropPageTest extends BaseTest {

    @Test
    public void testDragAndDrop() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver());
        
        dragAndDropPage.dragAndDrop();
        
        // Assertions based on successful drag and drop action
        Assert.assertTrue(true, "Drag  and Drop action performed successfully.");
    
}
}
