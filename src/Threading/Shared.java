package Threading;

/**
 * Created by vinod on 18/5/18.
 */
class Shared
{
    public Shared()
    {
        synchronized(this)
        {
            //synchronized block inside a constructor
        }
    }

    static
    {
        synchronized (Shared.class)
        {
            //synchronized block inside a static initializer
        }
    }

    {
        synchronized (this)
        {
            //synchronized block inside a instance initializer
        }
    }
}
