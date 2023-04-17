package idv.lance.youtube;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Video {
    String title;
    String description;
    int length;
}
