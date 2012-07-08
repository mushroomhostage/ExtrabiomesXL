package extrabiomes;

public class ItemCustomLeaves extends MultiItemBlock
{
    private static final int METADATA_USERPLACEDBIT = 4;

    private static int setUserPlacedOnMetadata(int var0)
    {
        return var0 | 4;
    }

    public ItemCustomLeaves(int var1)
    {
        super(var1);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int filterData(int var1)
    {
        return setUserPlacedOnMetadata(var1);
    }
}
