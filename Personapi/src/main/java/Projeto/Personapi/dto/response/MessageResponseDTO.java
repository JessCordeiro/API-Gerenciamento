package Projeto.Personapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    @SuppressWarnings("unused")
	private String message;

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	} 
	


	
}