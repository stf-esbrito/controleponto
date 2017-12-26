package br.com.stefanini.controlepontoback.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.controlepontoback.dto.AdminDTO;
import br.com.stefanini.controlepontoback.model.Admin;

public class AdminConverter {
	
	public static AdminDTO getAdminAsDTO(Admin adminModel) {
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(adminModel.getId());
		return adminDTO;
	}
	
	public static List<AdminDTO> toDTO(List<Admin> adminsModel){
		List<AdminDTO> adminsDTO = new ArrayList<>();
		if(!adminsModel.isEmpty()) {
			adminsModel.forEach(admin -> {
				adminsDTO.add(getAdminAsDTO(admin));
			});
		}
		return adminsDTO;
	}
}
