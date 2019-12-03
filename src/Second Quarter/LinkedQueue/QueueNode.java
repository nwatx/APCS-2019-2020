
public class QueueNode <T>
{
	// object will point to some object of type T
	private T object;

	// reference (memory address) of next LinkedNode
	private QueueNode nextQueueNode;


	// init constructor
	public QueueNode(T object)
	{
		// FINISH ME
		this.object    = object;
		nextQueueNode = null;
	}


	public T getObject()
	{
		// FINISH ME
		return this.object;
	}



	public QueueNode getNextQueueNode()
	{
		// FINISH ME
		// returns the memory address of the nextQueueNode
		return nextQueueNode;
	}


	public void setNextQueueNode(QueueNode nextQueueNode)
	{
		// FINISH ME
		// store the memory address of the nextQueueNode
		// nextQueueNode should hold the memory address
		this.nextQueueNode = nextQueueNode;
	}


	public String toString()
	{
		return object.toString();
	}
}
