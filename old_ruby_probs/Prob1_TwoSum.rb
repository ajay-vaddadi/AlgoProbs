# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
  num_hash = {}
  nums.each_index do |i|
    if not num_hash.has_key?(nums[i])
      num_hash.merge!({nums[i]=>[i]})
    else
      num_hash[nums[i]] << i
    end
  end

  ## Checking for pairs
  nums.each_index do |i|
    remainder = target-nums[i]
    if num_hash.has_key?(remainder)
      if nums[i] == remainder
        if num_hash[remainder].size == 2
          return num_hash[remainder]
        else
          next
        end
      end
      return [i,num_hash[remainder][0]]

    end
  end
end


puts two_sum([3,2,4],6)