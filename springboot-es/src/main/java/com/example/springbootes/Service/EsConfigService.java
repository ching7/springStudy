package com.example.springbootes.Service;

import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.elasticsearch.action.admin.indices.settings.put.UpdateSettingsRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.ccr.PutAutoFollowPatternRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName EsConfigService
 * @Description
 * @Author ynchen
 * @Date 2023/5/19 10:52
 * @Version V1.0.0
 */
@Service
public class EsConfigService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public AcknowledgedResponse updateNumberOfReplicas(String indexName, int numberOfReplicas) throws IOException {
        Map<String, Object> settings = Collections.singletonMap("number_of_replicas", numberOfReplicas);
        Document settingsDocument = Document.from(settings);
        return restHighLevelClient.indices().putSettings(new UpdateSettingsRequest(indexName).settings(settingsDocument), RequestOptions.DEFAULT);
    }

    public AcknowledgedResponse updateAliases(String index, String alias) throws IOException {
        IndicesAliasesRequest request = new IndicesAliasesRequest();
        IndicesAliasesRequest.AliasActions action =
                new IndicesAliasesRequest.AliasActions(IndicesAliasesRequest.AliasActions.Type.ADD)
                        .index(index)
                        .alias(alias);
        request.addAliasAction(action);
        return restHighLevelClient.indices().updateAliases(request, RequestOptions.DEFAULT);
    }

    public org.elasticsearch.client.core.AcknowledgedResponse autoFollowSet(String autoFollowName, String remoteCluster, String leaderIndexPatterns, String followIndexNamePattern) throws IOException {
        PutAutoFollowPatternRequest request = new PutAutoFollowPatternRequest(autoFollowName,
                remoteCluster,
                Arrays.asList(leaderIndexPatterns));
        request.setFollowIndexNamePattern(followIndexNamePattern);

        return restHighLevelClient.ccr().putAutoFollowPattern(request, RequestOptions.DEFAULT);
    }
}
