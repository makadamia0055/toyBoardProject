package com.ppl.toyboard.root.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ppl.toyboard.root.dto.InsertBoardDTO;
import com.ppl.toyboard.root.entity.Board;
import com.ppl.toyboard.root.vo.BoardVO;

@Mapper(componentModel = "spring")
public interface BoardMapper {
	BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);
	
	Board toEntity(InsertBoardDTO insertBoardDto);
	
	BoardVO toVO(Board board);


}
