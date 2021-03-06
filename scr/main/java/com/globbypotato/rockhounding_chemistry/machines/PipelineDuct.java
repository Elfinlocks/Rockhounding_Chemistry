package com.globbypotato.rockhounding_chemistry.machines;

import javax.annotation.Nullable;

import com.globbypotato.rockhounding_chemistry.ModBlocks;
import com.globbypotato.rockhounding_chemistry.handlers.Reference;
import com.globbypotato.rockhounding_chemistry.utils.ToolUtils;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class PipelineDuct extends PipelineBase {

	public PipelineDuct(float hardness, float resistance, String name) {
		super(hardness, resistance, name);
		setCreativeTab(Reference.RockhoundingChemistry);
	}

	@Override
    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, BlockPos sidePos, EnumFacing facing){
        IBlockState state = worldIn.getBlockState(sidePos);
        Block block = state.getBlock();
        return block instanceof PipelineHalt || block instanceof PipelineDuct || block instanceof PipelinePump || block instanceof PipelineValve ? true : false;
    }

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!worldIn.isRemote){
			if(ToolUtils.hasWrench(playerIn, EnumHand.MAIN_HAND)){
				worldIn.setBlockState(pos, ModBlocks.pipelineHalt.getDefaultState(), 2);
			}else{
				return false;
			}
		}
		return true;
	}

}