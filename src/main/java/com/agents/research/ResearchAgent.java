package com.agents.research;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.artifacts.BaseArtifactService;
import com.google.adk.artifacts.InMemoryArtifactService;
import com.google.adk.runner.Runner;
import com.google.adk.sessions.BaseSessionService;
import com.google.adk.sessions.InMemorySessionService;
import io.a2a.spec.AgentCard;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The ResearchAgent class is responsible for initiating research workflows, and is a Host Agent
 * which can communicate to other Agents, hence extending it to perform various tasks.
 */
public class ResearchAgent {
  private static final Logger ADK_LOGGER = Logger.getLogger(ResearchAgent.class.getName());

  private static final String AGENT_NAME = "Research_Agent";
  private static final String MODEL_NAME = "gemini-2.0-flash";

  private static final BaseAgent ROOT_AGENT;
  private static final Runner RUNNER;

  static {
    ROOT_AGENT = initAgent();
    RUNNER = initAgentRunner(ROOT_AGENT);
  }

  private String agents = "";
  private Map<String, AgentCard> agentCards = new HashMap<>();
  private Map<String, RemoteAgentConnection> remoteAgentConnections = new HashMap<>();

  private static BaseAgent initAgent() {
    return LlmAgent.builder().name(AGENT_NAME).build();
  }

  private static Runner initAgentRunner(BaseAgent agent) {
    BaseArtifactService artifactService = new InMemoryArtifactService();
    BaseSessionService sessionService = new InMemorySessionService();
    return new Runner(agent, AGENT_NAME, artifactService, sessionService);
  }
}
