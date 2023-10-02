package com.dellent.labseq.configurarion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String message;
}
