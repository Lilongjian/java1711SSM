package com.situ.ssm.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {

	void decreaseMoney(@Param("fromAccountId")Integer fromAccountId, @Param("money")Integer money);

	void increaseMoney(@Param("toAccountId")Integer toAccountId, @Param("money")Integer money);

}
