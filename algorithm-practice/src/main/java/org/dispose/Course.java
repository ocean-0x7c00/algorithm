package org.dispose;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private String cname;
    private List<CourseDetail> courseDetails;
}
