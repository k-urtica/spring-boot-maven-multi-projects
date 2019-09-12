package web.com.example.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import common.com.example.cache.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash
public class Bank extends AbstractEntity {

	@Id
	private String bankCode;

	private String bankSubCode;

	private String bankName;

	@CreatedDate
	private LocalDateTime crateadDate;

}
