import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import java.util.Arrays;

public class ElasticsearchDemo {

    private final ElasticsearchRestTemplate elasticsearchTemplate;
    private final UserRepository userRepository;

    public ElasticsearchDemo(ElasticsearchRestTemplate elasticsearchTemplate, UserRepository userRepository) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.userRepository = userRepository;
    }

    public void demo() {
        // 初始化索引
        IndexOperations indexOps = elasticsearchTemplate.indexOps(User.class);
        if (!indexOps.exists()) {
            indexOps.create();
            indexOps.putMapping();
        }

        // 插入数据
        User user = new User();
        user.setId("1");
        user.setName("Alice");
        user.setAge(30);

        IndexQuery query = new IndexQueryBuilder().withId(user.getId()).withObject(user).build();
        elasticsearchTemplate.index(query);

        // 查询数据
        SearchHits<User> hits = elasticsearchTemplate.search("1", User.class);
        for (SearchHit<User> hit : hits) {
            System.out.println(hit.getContent());
        }

        // 更新数据
        user.setName("Alicia");
        elasticsearchTemplate.save(user);

        // 删除数据
        elasticsearchTemplate.delete(Arrays.asList(user), User.class);

        // 清理索引
        indexOps.delete();
    }
}