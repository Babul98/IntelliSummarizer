package com.agents.research;

import com.google.adk.sessions.State;
import com.google.adk.tools.BaseTool;
import com.google.adk.tools.ToolContext;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendMessageTool extends BaseTool {
  private final ResearchAgent agentInstance;

  public SendMessageTool(ResearchAgent agentInstance) {
    super("send_message", "Sends message to all the other tools");
    this.agentInstance = agentInstance;
  }

  @Override
  public Single<Map<String, Object>> runAsync(Map<String, Object> args, ToolContext toolContext) {
    try {
      State state = toolContext.state();
      String agentName = (String) state.get("agent_name");
      String task = (String) state.get("task");

      List<Object> result = agentInstance.sendMessage(agentName, task, toolContext);
      Map<String, Object> response = new HashMap<>();
      response.put("result", result);
      return Single.just(response);
    } catch (Exception e) {
      Map<String, Object> errorResp = new HashMap<>();
      errorResp.put("error", "Failed to send message: " + e.getMessage());
      return Single.just(errorResp);
    }
  }
}
