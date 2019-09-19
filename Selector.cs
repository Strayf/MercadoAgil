using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class Selector : BTNode
{
    private List<BTNode> childNodes;
    public Selector(List<BTNode> nodes)
    {
        childNodes = nodes;
    }

    public override NodeStates Evaluate()
    {
        foreach (BTNode node in childNodes)
        {
            switch(node.Evaluate())
            {
                case NodeStates.FAILURE:
                    continue;
                case NodeStates.SUCESS:
                    currentNodeState = NodeStates.SUCESS;
                    return currentNodeState;
                case NodeStates.RUNNING:
                    currentNodeState = NodeStates.RUNNING;
                    return currentNodeState;
                default:
                    continue;
            }
        }
        currentNodeState = NodeStates.FAILURE;
        return currentNodeState;
    }
}
