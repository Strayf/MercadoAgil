using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class Sequence : BTNode
{
    private List<BTNode> childNodes;
    public Sequence(List<BTNode> nodes)
    {
        childNodes = nodes;
    }
    public override NodeStates Evaluate()
    {
        bool anyChildRunning = false;
        foreach (BTNode node in childNodes)
        {
            switch (node.Evaluate())
            {
                case NodeStates.FAILURE:
                    currentNodeState = NodeStates.FAILURE;
                    return currentNodeState;
                case NodeStates.SUCESS:
                    continue;
                case NodeStates.RUNNING:
                    anyChildRunning = true;
                    continue;
                default:
                    currentNodeState = NodeStates.SUCESS;
                    return currentNodeState;
            }
        }
        currentNodeState = anyChildRunning ? NodeStates.RUNNING : NodeStates.SUCESS;
        return currentNodeState;
    }
}