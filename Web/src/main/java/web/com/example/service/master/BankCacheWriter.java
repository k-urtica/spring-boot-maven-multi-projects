package web.com.example.service.master;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import common.com.example.cache.CacheWriter;
import web.com.example.entity.Bank;
import web.com.example.repository.BankRepository;

@Component
public class BankCacheWriter implements CacheWriter {

	private final BankRepository bankRepository;

	public BankCacheWriter(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}

	@Override
	public void cacheMasterData() {
		bankRepository.saveAll(createBankData());
	}

	// シュミレート用
	private List<Bank> createBankData() {
		List<Bank> banks = new ArrayList<>();
		banks.add(Bank.builder()
				.bankCode("AAA").bankSubCode("123").bankName("SMBC").build());
		banks.add(Bank.builder()
				.bankCode("AAA").bankSubCode("222").bankName("SMBC").build());
		banks.add(Bank.builder()
				.bankCode("BBB").bankSubCode("123").bankName("MUFG").build());
		banks.add(Bank.builder()
				.bankCode("CCC").bankSubCode("555").bankName("MIZUHO").build());
		return banks;
	}

}
