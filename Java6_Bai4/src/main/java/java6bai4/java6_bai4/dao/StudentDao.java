package java6bai4.java6_bai4.dao;

import com.fasterxml.jackson.databind.JsonNode;
import java6bai4.java6_bai4.bean.Student;
import java6bai4.java6_bai4.bean.StudentMap;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository // có @Repository nên đc coi là 1 spring bean
public class StudentDao {
    RestTemplate rest = new RestTemplate();

    String url = "https://java6-fpoly-183e2-default-rtdb.firebaseio.com/students.json";
    private String getUrl(String key) {
        return  url.replace(".json","/" + key + ".json");
    }

    public StudentMap findAll() {
        // đưa url -> nhận 1 tập hợp(Map) các student
        return rest.getForObject(url, StudentMap.class);
    }

    public Student findByKey(String key) {
        return rest.getForObject(getUrl(key), Student.class);
    }

    public String create(Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data); // data dc bọc trong cái entity
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText(); // key trả về
    }

    public Student update(String key, Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        rest.put(getUrl(key), entity);
        return data;// thực hiện update xong trả lại data
    }

    public void delete(String key) {
        rest.delete(getUrl(key));
    }
}
