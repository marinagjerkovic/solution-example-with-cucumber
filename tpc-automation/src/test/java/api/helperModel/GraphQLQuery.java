package api.helperModel;

import lombok.Data;

@Data
public class GraphQLQuery {
    private String query;
    private String variables;
}
