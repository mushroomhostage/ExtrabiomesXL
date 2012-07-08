package extrabiomes;

import net.minecraft.server.Block;
import net.minecraft.server.EntityCreature;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityMonster;
import net.minecraft.server.IAnimal;
import net.minecraft.server.Item;
import net.minecraft.server.PathfinderGoalLookAtPlayer;
import net.minecraft.server.PathfinderGoalRandomLookaround;
import net.minecraft.server.World;

public class EntityScarecrow extends EntityCreature implements IAnimal
{
    public EntityScarecrow(World var1)
    {
        super(var1);
        this.texture = "/extrabiomes/scarecrow.png";
        this.bf = true;
        this.goalSelector.a(7, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 50.0F));
        this.goalSelector.a(7, new PathfinderGoalLookAtPlayer(this, EntityCreature.class, 50.0F));
        this.goalSelector.a(7, new PathfinderGoalLookAtPlayer(this, EntityMonster.class, 50.0F));
        this.goalSelector.a(7, new PathfinderGoalRandomLookaround(this));
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean e_()
    {
        return false;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean n()
    {
        return false;
    }

    /**
     * Decrements the entity's air supply when underwater
     */
    protected int b_(int var1)
    {
        return var1;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropDeathLoot(boolean var1, int var2)
    {
        this.b(Item.STICK.id, 3);
        this.b(Block.MELON.id, 1);
        this.b(Block.PUMPKIN.id, 1);
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String k()
    {
        return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String j()
    {
        return null;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String i()
    {
        return null;
    }

    public int getMaxHealth()
    {
        return 5;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float p()
    {
        return 0.0F;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean c_()
    {
        return true;
    }
}
