package com.Badadamadaba.badadevicesmod.blocks;

import com.Badadamadaba.badadevicesmod.init.ModBlocks;

import com.Badadamadaba.badadevicesmod.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class computer extends BlockBase
{
	public static final AxisAlignedBB COMPUTER_N = new AxisAlignedBB(0.0D, 0.0D, 1.0D, 1.0D, 0.25D, 0.0D);
    public static final AxisAlignedBB COMPUTER_E = new AxisAlignedBB(1.0D, 0.0D, 0.0D, 0.0D, 0.25D, 1.0D);
    public static final AxisAlignedBB COMPUTER_W = new AxisAlignedBB(1.0D, 0.0D, 0.0D, 0.0D, 0.25D, 1.0D);
    public static final AxisAlignedBB COMPUTER_S = new AxisAlignedBB(0.0D, 0.0D, 1.0D, 1.0D, 0.25D, 0.0D);
    
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
		this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH));
	}
			
	public computer(String name, Material material)
	{
		super(name, material);
		setUnlocalizedName(name);
		
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(30.0F);
		setHarvestLevel("pickaxe", 0);
		setLightLevel(0.5F);
		setLightOpacity(1);
	}

		@Override
		public IBlockState getStateFromMeta(int meta) 
	    {
			EnumFacing facing = EnumFacing.getFront(meta);

			if(facing.getAxis()==EnumFacing.Axis.Y) 
			{
				facing=EnumFacing.SOUTH;
			}
			return getDefaultState().withProperty(FACING, facing);
	    }

		@Override
		public int getMetaFromState(IBlockState state) 
	    {
			return state.getValue(FACING).getIndex();
	    }

	    @Override
		protected BlockStateContainer createBlockState() 
	    {
	    	return new BlockStateContainer(this, FACING);
	    }

	    @Override
	    public IBlockState getStateForPlacement(World worldIn, BlockPos pos,EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
	    {
		  return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	    }
		
		private boolean canBlockStay(World worldIn, BlockPos pos)
		{
			return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
		}
		
		@Override
		public boolean canPlaceBlockAt(World worldIn, BlockPos pos) 
		{
			return super.canPlaceBlockAt(worldIn, pos) && this.canBlockStay(worldIn, pos);
		}
		
		@Override
		public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) 
		{
			if(!this.canBlockStay(worldIn, pos))
			{
				worldIn.setBlockToAir(pos);
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.COMPUTER));
			}
		}
		
		@Override
		public BlockRenderLayer getBlockLayer() 
		{
			return BlockRenderLayer.CUTOUT;
		}
		
		@Override
		public boolean isFullBlock(IBlockState state) 
		{
			return false;
		}
		
		@Override
		public boolean isFullCube(IBlockState state) 
		{
			return false;
		}
		
		@Override
		public boolean isOpaqueCube(IBlockState state) 
		{
			return false;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
		{
			switch(state.getValue(FACING))
	        {
	            case NORTH:
	            default:
	                return COMPUTER_N;
	            case SOUTH:
	                return COMPUTER_S;
	            case EAST:
	                return COMPUTER_E;
	            case WEST:
	                return COMPUTER_W;
	        }
		}

	@Override	
	public void registerModels() 
	{
		ClientProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}
