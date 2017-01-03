
# @param {String} s
# @return {Integer}
def roman_to_int(s)
  roman_to_int_map = { "I" => 1, "V" => 5, "X" => 10, "L" => 50, "C" => 100, "D" =>500, "M" => 1000}
  return 0 if s.size == 0
  return 0 if s.nil?
  integer_representation = 0
  i = s.size-1
  return 0 if not valid_roman_literal?(s[i])
  integer_representation = integer_representation+roman_to_int_map[s[i]]
  i = i-1
  while i>=0 do
    current = s[i]
    return 0 if not valid_roman_literal?(current)
    prev = s[i+1]
    if roman_to_int_map[current] >= roman_to_int_map[prev]
      integer_representation = integer_representation + roman_to_int_map[current]
    else
      integer_representation = integer_representation - roman_to_int_map[current]
    end
    i = i-1
  end
  return integer_representation
end

def valid_roman_literal?(literal)
  roman_to_int_map = { "I" => 1, "V" => 5, "X" => 10, "L" => 50, "C" => 100, "D" =>500, "M" => 1000}
  return roman_to_int_map.has_key?(literal)
end

puts roman_to_int("XXVII")