package visual;

import java.io.File;
import java.util.Map;

import in.testonics.omni.image.VisualComparison;
import in.testonics.omni.image.model.VisualComparisonResult;
import org.springframework.web.bind.annotation.*;

@RestController
class VisualController {

//    @GetMapping(value = "/visual-comparison")
//    Map<String, String> all(@RequestParam String image1, @RequestParam String image2) {
//        return all(new File(image1), new File(image2));
//    }

    @GetMapping(value = "/healthcheck")
    String healthcheck() {
        return "API Running";
    }

    @GetMapping(value = "/visual-comparison")
    Map<String, String> all(@RequestParam File image1, @RequestParam File image2) {
        //Sets the object of Visual Comparison
        VisualComparison visualComparison = new VisualComparison();
        visualComparison.setResizeImage(true);
        //Set below parameters if textual comparison is required
        visualComparison.setExtractImageFlag(true);
        //Download the language file from the link and set the folder path
        visualComparison.setLanguagePath(".\\src\\main\\resources\\language");
        visualComparison.setPrintCoordinates(true);
        visualComparison.setCoordinatesExcludeFilePath(".\\src\\test\\resources\\TestData\\CoordinatesToExclude.csv");

        VisualComparisonResult visualComparisonResult = visualComparison.compareImages(image1, image2);
        Map<String, String> mismatch = visualComparisonResult.getMismatch();
        mismatch.put("Percentile Difference",String.valueOf(visualComparisonResult.getDifferencePercent()));

        return mismatch;
    }
}