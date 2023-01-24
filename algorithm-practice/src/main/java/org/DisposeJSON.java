package org;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.dispose.Course;
import org.dispose.CourseDetail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisposeJSON {

    private static void readJsonFromFile(ArrayList<String> list) throws IOException {
        FileInputStream inputStream = new FileInputStream("/Users/ocean/IdeaProjects/algorithm/algorithm-practice/src/main/resources/class");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            list.add(str);
        }

        //close
        inputStream.close();
        bufferedReader.close();
    }

    private static void prase(ArrayList<String> list, ArrayList<Course> resultList) {
        Gson gson = new Gson();

        for (String str : list) {
            HashMap map = gson.fromJson(str, HashMap.class);
            LinkedTreeMap result = (LinkedTreeMap) map.get("result");
            List<LinkedTreeMap> mapList = (List<LinkedTreeMap>) result.get("map_list");
            List<LinkedTreeMap> mapCourses = (List<LinkedTreeMap>) mapList.get(0).get("map_courses");
            for (LinkedTreeMap mapCours : mapCourses) {
                List<LinkedTreeMap> chapterList = (List<LinkedTreeMap>) mapCours.get("chapter_list");
                List<LinkedTreeMap> subCourseList = (List<LinkedTreeMap>) chapterList.get(0).get("sub_course_list");

                ArrayList<CourseDetail> details = new ArrayList<>();

                for (LinkedTreeMap treeMap : subCourseList) {
                    CourseDetail courseDetail = new CourseDetail();
                    courseDetail.setSubId(Integer.valueOf(treeMap.get("sub_id").toString().split("\\.")[0]) + 1);
                    courseDetail.setName(treeMap.get("name").toString());
                    details.add(courseDetail);
                }


                Course course = new Course();
                course.setCname(mapCours.get("cname").toString());
                course.setCourseDetails(details);
                resultList.add(course);
            }


        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        readJsonFromFile(list);

        ArrayList<Course> resultList = new ArrayList<>();
        prase(list, resultList);

        resultList.sort((o1, o2) -> o1.getCname().toCharArray().length - o2.getCname().toCharArray().length);

        for (Course course : resultList) {
            System.out.println(course.getCname());
            for (CourseDetail courseDetail : course.getCourseDetails()) {
                System.out.println(courseDetail.getSubId() + "\t" + courseDetail.getName());
            }
            System.out.println();
            System.out.println();
        }

        System.out.println();
    }


}
