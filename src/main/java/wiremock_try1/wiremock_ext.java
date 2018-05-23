package wiremock_try1;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

public class wiremock_ext extends ResponseTransformer {

    private final stubs stubhandler;
    private WireMockServer wireMockServer;

    public wiremock_ext(){
        this.stubhandler = new stubs();
    }


    @Override
    public String getName() {
        return "wiremockext";
    }

    @Override
    public boolean applyGlobally() {
        return false;
    }



        @Override
        public Response transform(Request request, Response response, FileSource files, Parameters parameters) {
            return Response.Builder.like(response)
                    .but().body(parameters.getString("name") + ", "
                            + parameters.getInt("number") + ", "
                            + parameters.getBoolean("flag"))
                    .build();
        }





}
